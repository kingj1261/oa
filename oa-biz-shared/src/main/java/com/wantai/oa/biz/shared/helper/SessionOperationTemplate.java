package com.wantai.oa.biz.shared.helper;

/**
 * Desc: 简要信息
 * Date: 2016-01-16
 * Time: 下午 3:40
 * author: weiquan
 * Created by IntelliJ IDEA.
 */

import com.alibaba.fastjson.JSONObject;
import com.wantai.oa.biz.shared.vo.UserInfoVO;
import com.wantai.oa.cache.util.BaseRedisTemplate;
import com.wantai.oa.common.lang.constants.RedisKey;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Repository;

/**
 *
 * @Description: sesstion的相关操作
 *
 * @author yujuncai
 * @date 2015年12月19日
 *
 */

@Repository
public class SessionOperationTemplate extends BaseRedisTemplate {

	protected Logger logger = Logger.getLogger(this.getClass().getName());



	/**
	 * 设置键过期时间
	 *
	 * @param key
	 * @param expire
	 * @param Time
	 */
	/*
	 * private void setExpire(String key, long expire, TimeUnit Time) { if
	 * (key!=null && key.trim().length()>0) { redisTemplate.expire(key, expire,
	 * Time); } }
	 */

	/**
	 * 移除在线登陆用户
	 *
	 * @param sid
	 *            source 为来源为后续app预留
	 * @return
	 * @throws Exception
	 */
	public boolean removeOnLinuUser(final String sid, final String source)
			throws Exception {
		if (sid != null) {
			final String key;
			key = getJointName(sid);
			Boolean falg = redisTemplate.execute(new RedisCallback<Boolean>() {
				public Boolean doInRedis(RedisConnection connection)
						throws DataAccessException {
					connection.select(2);
					Long del = connection.del(key.getBytes());
					if (del == 1) {
						return true;
					} else {
						return false;
					}

				}
			});

			return falg;
		}
		return false;
	}

	private String getJointName(String sid) {
		String key = RedisKey.OnLinuUserKey + ":" + sid;
		return key;
	}

	/**
	 * 获取在线用户信息
	 *
	 * @param sid
	 *            source 为来源为后续app预留
	 * @return
	 * @throws Exception
	 */
	public UserInfoVO getOnLinuUser(String sid, final String source)
			throws Exception {
		final String key;
		key = getJointName(sid);
		UserInfoVO userInfo = redisTemplate
				.execute(new RedisCallback<UserInfoVO>() {
					public UserInfoVO doInRedis(RedisConnection connection)
							throws DataAccessException {
						connection.select(2);
						byte[] bs = connection.get(key.getBytes());
						String byteToString = byteToString(bs);
						UserInfoVO userinfo = JSONObject.parseObject(
								byteToString, UserInfoVO.class);
						/*if (userinfo != null) {
							// 如果用户已登录，则增加在线时间
							connection.expire(key.getBytes(),
									RedisExpire.ThirtyMinuteSecend);

						}*/
						return userinfo;
					}
				});

		return userInfo;
	}
}


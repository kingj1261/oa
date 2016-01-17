package com.wantai.oa.cache.util;

import com.wantai.oa.common.lang.exception.RedisDataAccessException;
import com.wantai.oa.common.util.BaseUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisListCommands.Position;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.Map.Entry;


@Repository
public class BaseRedisTemplate {

	protected Logger logger = Logger.getLogger(this.getClass().getName());

	private static final String REDIS_CHARSET = "utf-8";	

	/** 缓存1个月 **/
	public static final long LIVE_TIME_MONTH = 30 * 7 * 24 * 60 * 60;
	/** 缓存1周 **/
	public static final long LIVE_TIME_WEEK = 7 * 24 * 60 * 60;
	/** 缓存1天 **/
	public static final long LIVE_TIME_DAY = 24 * 60 * 60;
	/** 缓存1小时 **/
	public static final long LIVE_TIME_HOUR = 60 * 60;
	/** 缓存1分钟 **/
	public static final long LIVE_TIME_MIN = 60;
	/** 缓存1秒 **/
	public static final long LIVE_TIME_SEC = 1l;

	@Resource
	protected RedisTemplate<Serializable, Serializable> redisTemplate;

	/*****************************************************/
	/********************* key 操作 **********************/
	/*****************************************************/

	/**
	 * 封装redis缓存服务接口
	 * 
	 * @param keys
	 * @return 删除的条数
	 * @throws
	 * @author chenzj
	 * @date 2015年8月25日
	 */
	public Long del(final String... keys) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				long result = 0;
				for (int i = 0; i < keys.length; i++) {
					result = connection.del(keys[i].getBytes());
				}
				return result;
			}
		});
	}

	/**
	 * 设置key的过期时间，单位秒
	 * 
	 * @param key
	 * @param liveTime
	 *            秒数
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月25日
	 */
	public Boolean expire(final String key, final long liveTime) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.expire(key.getBytes(), liveTime);
			}
		});
	}

	/**
	 * 把指定key置为永久有效
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Boolean persist(final String key) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.persist(key.getBytes());
			}
		});
	}

	/**
	 * 查询key的生命周期 对于不存在的key或已过期的key/不过期的key,都返回-1
	 * 
	 * @param key
	 * @return 秒数
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long ttl(final String key) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.ttl(key.getBytes());
			}
		});
	}

	/**
	 * 检查key是否已经存在
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public boolean exists(final String key) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.exists(key.getBytes());
			}
		});
	}

	/*****************************************************/
	/******************** 字符串操作 **********************/
	/*****************************************************/

	/**
	 * 添加key value 并且设置存活时间(byte)
	 * 
	 * @param key
	 * @param value
	 * @param liveTime
	 *            存活时间
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public void set(final byte[] key, final byte[] value, final long liveTime) {
		redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(key, value);
				if (liveTime > 0) {
					connection.expire(key, liveTime);
				}
				return 1L;
			}
		});
	}

	/**
	 * 添加key value 并且设置存活时间
	 * 
	 * @param key
	 * @param value
	 * @param liveTime
	 *            存活时间
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public void set(String key, String value, long liveTime) {
		this.set(key.getBytes(), value.getBytes(), liveTime);
	}

	/**
	 * 添加key value
	 * 
	 * @param key
	 * @param value
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public void set(String key, String value) {
		this.set(key, value, 0L);
	}

	/**
	 * 添加key value (字节)(序列化)
	 * 
	 * @param key
	 * @param value
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public void set(byte[] key, byte[] value) {
		this.set(key, value, 0L);
	}

	/**
	 * 获取redis value (String)
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public String get(final String key) {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				return byteToString(connection.get(key.getBytes()));
			}
		});
	}

	/**
	 * 通过正则匹配keys
	 * 
	 * @param pattern
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Set<Serializable> getKeys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	/**
	 * 值增加1
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long incr(final String key) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.incr(key.getBytes());
			}
		});
	}

	/**
	 * 值增加number
	 * 
	 * @param key
	 * @param number
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月25日
	 */
	public Long incrBy(final String key, final long number) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.incrBy(key.getBytes(), number);
			}
		});
	}

	/**
	 * 值增加number
	 * 
	 * @param key
	 * @param number
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月25日
	 */
	public Double incrBy(final String key, final double number) {
		return redisTemplate.execute(new RedisCallback<Double>() {
			public Double doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.incrBy(key.getBytes(), number);
			}
		});
	}

	/**
	 * 值减少1
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long decr(final String key) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.decr(key.getBytes());
			}
		});
	}

	/**
	 * 值减少number
	 * 
	 * @param key
	 * @param number
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月25日
	 */
	public Long decrBy(final String key, final long number) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.decrBy(key.getBytes(), number);
			}
		});
	}

	/*****************************************************/
	/******************* link链表操作 *********************/
	/*****************************************************/

	/**
	 * 把值插入到链接头部
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long lpush(final String key, final String value) {
		return this.lpush(key, value, 0l);
	}

	/**
	 * 把值插入到链接头部，并设置过期时间
	 * 
	 * @param key
	 * @param value
	 * @param liveTime
	 *            过期时间(秒)
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long lpush(final String key, final String value, final long liveTime) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long r = connection.lPush(key.getBytes(), value.getBytes());
				if (liveTime > 0)
					connection.expire(key.getBytes(), liveTime);
				return r;
			}
		});
	}

	/**
	 * 把值插入到链接尾部
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long rpush(final String key, final String value) {
		return this.rpush(key, value, 0l);
	}

	/**
	 * 把值插入到链接尾部，并设置过期时间
	 * 
	 * @param key
	 * @param value
	 * @param liveTime
	 *            过期时间(秒)
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long rpush(final String key, final String value, final long liveTime) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long r = connection.rPush(key.getBytes(), value.getBytes());
				if (liveTime > 0)
					connection.expire(key.getBytes(), liveTime);
				return r;
			}
		});
	}

	/**
	 * 返回并删除链表头元素
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public String lpop(final String key) {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				return byteToString(connection.lPop(key.getBytes()));
			}
		});
	}

	/**
	 * 返回并删除链表尾元素
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public String rpop(final String key) {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				return byteToString(connection.rPop(key.getBytes()));
			}
		});
	}

	/**
	 * 返回链表key中所有元素
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<String> lrangeAll(String key) {
		return byteListToStrList(this.lrangeAllByte(key));
	}

	/**
	 * 返回链表key中所有元素
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<byte[]> lrangeAllByte(final String key) {
		return redisTemplate.execute(new RedisCallback<List<byte[]>>() {
			public List<byte[]> doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.lRange(key.getBytes(), 0, -1);
			}
		});
	}

	/**
	 * 返回链表中[start ,stop]中的元素
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<String> lrange(final String key, final long start,
			final long end) {
		return byteListToStrList(this.lrangeByte(key, start, end));
	}

	/**
	 * 返回链表中[start ,stop]中的元素
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<byte[]> lrangeByte(final String key, final long start,
			final long end) {
		return redisTemplate.execute(new RedisCallback<List<byte[]>>() {
			public List<byte[]> doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.lRange(key.getBytes(), start, end);
			}
		});

	}

	/**
	 * 计算链接表的元素个数
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long llen(final String key) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.lLen(key.getBytes());
			}
		});
	}

	/**
	 * 从key链表中删除 value值 注: 删除count的绝对值个value后结束
	 * 
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long rpop(final String key, final long count, final String value) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.lRem(key.getBytes(), count, value.getBytes());
			}
		});
	}

	/**
	 * 在pivot的前或后边添加元素value
	 * 
	 * @param key
	 * @param where
	 * @param pivot
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月25日
	 */
	public Long linsert(final String key, final Position where,
			final String pivot, final String value) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.lInsert(key.getBytes(), where,
						pivot.getBytes(), value.getBytes());
			}
		});
	}

	/*****************************************************/
	/******************** set集合操作 *********************/
	/*****************************************************/

	/**
	 * 往集合key中增加元素集合
	 * 
	 * @param key
	 * @param values
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long sadd(final String key, final byte[]... values) {
		return this.sadd(key, 0l, values);
	}
	
	/**
	 * 往集合key中增加元素集合
	 * 
	 * @param key
	 * @param values
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long sadd(final String key, final List<String> values) {
		if(values == null || values.size() == 0)
			return 0l;
		return this.sadd(key, 0l,(byte[][]) strListToByteList(values).toArray());
	}
	
	/**
	 * 往集合key中增加元素，并设置过期时间
	 * 
	 * @param key
	 * @param liveTime
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long sadd(final String key, final long liveTime, final String value) {
		return this.sadd(key, liveTime, value.getBytes());
	}

	/**
	 * 往集合key中增加元素
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long sadd(final String key, final String value) {
		return this.sadd(key, 0l, value.getBytes());
	}

	/**
	 * 往集合key中增加元素集合，并设置过期时间
	 * 
	 * @param key
	 * @param values
	 * @param liveTime
	 *            过期时间(秒)
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long sadd(final String key, final long liveTime,
			final byte[]... values) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long r = connection.sAdd(key.getBytes(), values);
				if (liveTime > 0)
					connection.expire(key.getBytes(), liveTime);
				return r;
			}
		});
	}

	/**
	 * 删除集合中集为 values的元素
	 * 
	 * @param key
	 * @param values
	 * @return 忽略不存在的元素后,真正删除掉的元素的个数
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long sRem(final String key, final byte[]... values) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.sRem(key.getBytes(), values);
			}
		});
	}

	/**
	 * 查询并删除集合中key中1个随机元素
	 * 
	 * @param key
	 * @return 返回并删除集合中key中1个随机元素
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public String spop(final String key) {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				return byteToString(connection.sPop(key.getBytes()));
			}
		});
	}

	/**
	 * 返回集合中随机一个元素
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public String sRandMember(final String key) {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				return byteToString(connection.sRandMember(key.getBytes()));
			}
		});
	}

	/**
	 * 判断value是否在key集合中
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Boolean sIsMember(final String key, final String value) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.sIsMember(key.getBytes(), value.getBytes());
			}
		});
	}

	/**
	 * 获取集合中所有的元素
	 * 
	 * @param key
	 * @param value
	 * @return 返回集合中所有的元素
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<String> sMembers(final String key, final String value) {
		Set<byte[]> values = redisTemplate
				.execute(new RedisCallback<Set<byte[]>>() {
					public Set<byte[]> doInRedis(RedisConnection connection)
							throws DataAccessException {
						return connection.sMembers(key.getBytes());
					}
				});
		return byteSetToStrSet(values);
	}

	/**
	 * 获取集合中元素的个数
	 * 
	 * @param key
	 * @return 返回集合中元素的个数
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long scard(final String key) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.sCard(key.getBytes());
			}
		});
	}
	
	/*****************************************************/
	/*************** order set有序集合操作 ****************/
	/*****************************************************/

	/**
	 * 添加1个元素
	 * 
	 * @param key
	 * @param score
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Boolean zadd(final String key, final double score, final String value) {
		return zadd(key, score, value, 0l);
	}

	/**
	 * 添加1个元素，并设置过期时间
	 * 
	 * @param key
	 * @param score
	 * @param value
	 * @param liveTime
	 *            过期时间 (秒)
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Boolean zadd(final String key, final double score,
			final String value, final long liveTime) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				Boolean r = connection.zAdd(key.getBytes(), score,
						value.getBytes());
				if (liveTime > 0)
					connection.expire(key.getBytes(), liveTime);
				return r;
			}
		});
	}

	/**
	 * 删除集合中的元素
	 * 
	 * @param key
	 * @param values
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long zRem(final String key, final byte[]... values) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zRem(key.getBytes(), values);
			}
		});
	}

	/**
	 * 按照socre来删除元素,删除score在[min,max]之间的
	 * 
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long zRemRangeByScore(final String key, final double min,
			final double max) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zRemRangeByScore(key.getBytes(), min, max);
			}
		});
	}

	/**
	 * 按排名删除元素,删除名次在[begin,end]之间的
	 * 
	 * @param key
	 * @param begin
	 * @param end
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long zRemRangeByRank(final String key, final long begin,
			final long end) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zRemRange(key.getBytes(), begin, end);
			}
		});
	}

	/**
	 * 返回有序集key中，score值介于max和min之间(默认包括等于max或min)的所有的成员。有序集成员按score值递减(从大到小)的次序排列。
	 * @author 肖红斌
	 * @date 2015年12月4日上午11:49:01
	 */
	public List<String> zRevRangeByScore(final String key, final double begin,
				final double end){
		Set<byte[]> values =  redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
			public Set<byte[]> doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zRevRangeByScore(key.getBytes(), begin, begin);
			}
		});
		return byteSetToStrSet(values);
	}
	
	/**
	 * 返回有序集key中，所有score值介于min和max之间(包括等于min或max)的成员。有序集成员按score值递增(从小到大)次序排列。
	 * @author 肖红斌
	 * @date 2015年12月4日上午11:49:01
	 */
	public List<String> zRangeByScore(final String key, final double begin,
				final double end){
		Set<byte[]> values =  redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
			public Set<byte[]> doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zRevRangeByScore(key.getBytes(), begin, begin);
			}
		});
		return byteSetToStrSet(values);
	}
	
	/**
	 * 返回指定score的value
	 * @author 肖红斌
	 * @date 2015年12月4日上午11:49:01
	 */
	public String zRangeByScore(final String key, final double store){
		List<String> list = zRangeByScore(key, store, store);
		if(BaseUtils.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
  	}	
	
	/**
	 * 查询value的排名(升续 0名开始)
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long zRank(final String key, final String value) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zRank(key.getBytes(), value.getBytes());
			}
		});
	}

	/**
	 * 查询 value的排名(降续 0名开始)
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long zRevRank(final String key, final String value) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zRevRank(key.getBytes(), value.getBytes());
			}
		});
	}

	/**
	 * 把集合升序排序后,返回名次[begin,end]的元素 升序排列
	 * 
	 * @param key
	 * @param begin
	 * @param end
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<String> zRange(final String key, final long begin,
			final long end) {
		Set<byte[]> values = redisTemplate
				.execute(new RedisCallback<Set<byte[]>>() {
					public Set<byte[]> doInRedis(RedisConnection connection)
							throws DataAccessException {
						return connection.zRange(key.getBytes(), begin, end);
					}
				});
		return byteSetToStrSet(values);
	}

	/**
	 * 把集合降序排序后,返回名次[begin,end]的元素 降序排列
	 * 
	 * @param key
	 * @param begin
	 * @param end
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<String> zRevRange(final String key, final long begin,
			final long end) {
		Set<byte[]> values = redisTemplate
				.execute(new RedisCallback<Set<byte[]>>() {
					public Set<byte[]> doInRedis(RedisConnection connection)
							throws DataAccessException {
						return connection.zRevRange(key.getBytes(), begin, end);
					}
				});
		return byteSetToStrSet(values);
	}

	/**
	 * 获取元素个数
	 * 
	 * @param key
	 * @return 返回元素个数
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long zCard(final String key) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zCard(key.getBytes());
			}
		});
	}

	/**
	 * 返回[min,max]区间内元素的数量
	 * 
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long zCount(final String key, final double min, final double max) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.zCount(key.getBytes(), min, max);
			}
		});
	}

	/*****************************************************/
	/******************** hash哈希操作 ********************/
	/*****************************************************/

	/**
	 * 把key中 filed域的值设为value 注:如果没有field域,直接添加,如果有,则覆盖原field域的值
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Boolean hSet(final String key, final String field, final String value) {
		return this.hSet(key, field, value, 0l);
	}

	/**
	 * 把key中 filed域的值设为value，并设置过期时间 注:如果没有field域,直接添加,如果有,则覆盖原field域的值
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @param liveTime
	 *            过期时间(秒)
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Boolean hSet(final String key, final String field,
			final String value, final long liveTime) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				Boolean r = connection.hSet(key.getBytes(), field.getBytes(),
						value.getBytes());
				if (liveTime > 0)
					connection.expire(key.getBytes(), liveTime);
				return r;
			}
		});
	}

	/**
	 * 添加map元素
	 * 
	 * @param key
	 * @param hashes
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public void hSet(final String key, final Map<String, String> hashes) {
		this.hSet(key, hashes, 0l);
	}

	/**
	 * 添加map元素
	 * 
	 * @param key
	 * @param hashes
	 * @param liveTime
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public void hSet(final String key, final Map<String, String> hashes,
			final long liveTime) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				Iterator<Entry<String, String>> it = hashes.entrySet()
						.iterator();
				while (it.hasNext()) {
					Entry<String, String> et = it.next();
					hSet(key, et.getKey(), et.getValue());
				}
				if (liveTime > 0)
					connection.expire(key.getBytes(), liveTime);
				return null;
			}
		});
	}

	/**
	 * 添加map元素
	 * 
	 * @param key
	 * @param hashes
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public void hSetByteMap(final String key, final Map<byte[], byte[]> hashes) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.hMSet(key.getBytes(), hashes);
				return null;
			}
		});
	}

	/**
	 * 返回key中field域的值
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public String hGet(final String key, final String field) {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				return byteToString(connection.hGet(key.getBytes(),
						field.getBytes()));
			}
		});
	}

	/**
	 * 返回key中fields域的值
	 * 
	 * @param key
	 * @param fields
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<String> hGet(final String key, final byte... fields) {
		return byteListToStrList(this.hGetsByte(key, fields));
	}

	/**
	 * 返回key中fields域的值
	 * 
	 * @param key
	 * @param fields
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<byte[]> hGetsByte(final String key, final byte... fields) {
		return redisTemplate.execute(new RedisCallback<List<byte[]>>() {
			public List<byte[]> doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.hMGet(key.getBytes(), fields);
			}
		});
	}

	/**
	 * 返回key中,所有域与其值
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Map<String, String> hGetAll(final String key) {
		Map<byte[], byte[]> values = redisTemplate
				.execute(new RedisCallback<Map<byte[], byte[]>>() {
					public Map<byte[], byte[]> doInRedis(
							RedisConnection connection)
							throws DataAccessException {
						return connection.hGetAll(key.getBytes());
					}
				});
		return byteMapToStrMap(values);
	}

	/**
	 * 删除key中 field域
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long hDel(final String key, final String field) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.hDel(key.getBytes(), field.getBytes());
			}
		});
	}

	/**
	 * 返回key中元素的数量
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long hLen(final String key) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.hLen(key.getBytes());
			}
		});
	}

	/**
	 * 判断key中有没有field域
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Boolean hExists(final String key, final String field) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.hExists(key.getBytes(), field.getBytes());
			}
		});
	}

	/**
	 * 返回key中所有的field
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<String> hKeys(final String key) {
		Set<byte[]> values = redisTemplate
				.execute(new RedisCallback<Set<byte[]>>() {
					public Set<byte[]> doInRedis(RedisConnection connection)
							throws DataAccessException {
						return connection.hKeys(key.getBytes());
					}
				});
		return byteSetToStrSet(values);
	}

	/**
	 * 返回key中所有的value
	 * 
	 * @param key
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public List<String> hVals(final String key) {
		List<byte[]> values = redisTemplate
				.execute(new RedisCallback<List<byte[]>>() {
					public List<byte[]> doInRedis(RedisConnection connection)
							throws DataAccessException {
						return connection.hVals(key.getBytes());
					}
				});
		return byteListToStrList(values);
	}

	/**
	 * 把key中的field域的值增长整型值delta
	 * 
	 * @param key
	 * @param field
	 * @param delta
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Long hIncrBy(final String key, final String field, final long delta) {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.hIncrBy(key.getBytes(), field.getBytes(),
						delta);
			}
		});
	}

	/**
	 * 把key中的field域的值增长浮点值delta
	 * 
	 * @param key
	 * @param field
	 * @param delta
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public Double hIncrBy(final String key, final String field,
			final double delta) {
		return redisTemplate.execute(new RedisCallback<Double>() {
			public Double doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.hIncrBy(key.getBytes(), field.getBytes(),
						delta);
			}
		});
	}

	/*****************************************************/
	/********************* 其他操作 **********************/
	/*****************************************************/

	/**
	 * 清空redis 所有数据(慎用)
	 * 
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public String flushDB() {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.flushDb();
				return "ok";
			}
		});
	}

	/**
	 * 查看redis里有多少数据
	 * 
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public long dbSize() {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.dbSize();
			}
		});
	}

	/**
	 * 检查是否连接成功
	 * 
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	public String ping() {
		return redisTemplate.execute(new RedisCallback<String>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.ping();
			}
		});
	}

	/**
	 * byte数组转为String
	 * 
	 * @param bytes
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	protected String byteToString(byte[] bytes) {
		if (bytes == null)
			return null;
		if (bytes.length == 0)
			return "";
		try {
			return new String(bytes, REDIS_CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RedisDataAccessException(e);
		}
	}
	
	/**
	 * String转为 byte数组
	 *
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	protected byte[] stringToByte(String value) {
		if (value == null)
			return null;
		try {
			return value.getBytes(REDIS_CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RedisDataAccessException(e);
		}
	}

	/**
	 * byte数组集合转为字符串集合
	 * 
	 * @param values
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	protected List<String> byteListToStrList(List<byte[]> values) {
		if (values == null)
			return null;
		List<String> results = new LinkedList<String>();
		for (byte[] value : values)
			results.add(byteToString(value));
		return results;
	}
	
	/**
	 * 字符串集合转为byte数组集合
	 * 
	 * @param values
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	protected List<byte[]> strListToByteList(List<String> values) {
		if (values == null)
			return null;
		List<byte[]> results = new LinkedList<byte[]>();
		for (String value : values)
			results.add(stringToByte(value));
		return results;
	}
	
	/**
	 * byte数组集合转为字符串集合
	 * 
	 * @param values
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	protected List<String> byteSetToStrSet(Set<byte[]> values) {
		if (values == null)
			return null;
		// Set<String> results = new HashSet<String>();
		List<String> results = new LinkedList<String>();
		for (byte[] value : values)
			results.add(byteToString(value));
		return results;
	}

	/**
	 * byte数组map转为字符串map
	 * 
	 * @param values
	 * @return
	 * @throws
	 * @author xieshuhan
	 * @date 2015年8月26日
	 */
	protected Map<String, String> byteMapToStrMap(Map<byte[], byte[]> values) {
		if (values == null)
			return null;
		Map<String, String> results = new HashMap<String, String>();
		Iterator<Entry<byte[], byte[]>> it = values.entrySet().iterator();
		while (it.hasNext()) {
			Entry<byte[], byte[]> et = it.next();
			results.put(byteToString(et.getKey()), byteToString(et.getValue()));
		}
		return results;
	}

	public Long getMaxId(String key) {
		if (this.exists(key)) {
			this.incr(key);
			return Long.parseLong(this.get(key));

		} else {
			this.set(key, "1");
			return 1L;
		}
	}
}

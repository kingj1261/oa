/**
 * Wantai.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.wantai.oa.web.controller.process;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 流程控制器
 * @author maping.mp
 * @version $Id: LoginController.java, v 0.1 2015-1-04 下午10:55:39 maping.mp Exp $
 */
@RestController
public class ProcessController {

    @Autowired
    private TaskService       taskService;

    @Autowired
    private RuntimeService    runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private ObjectMapper      objectMapper;

    /**
     * 导航到流程设计器界面
     */
    @RequestMapping("modeler")
    public ModelAndView go2Modeler(ModelAndView mav) {
        mav.setViewName("process/modeler");
        return mav;
    }

    /**
     * 列举出所有已经创建的流程
     */
    @RequestMapping("list")
    public List<Model> queryAllModels() {
        return repositoryService.createModelQuery().orderByCreateTime().asc().list();
    }

    /**
     * 新建一个模型，返回新建模型的id
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("add")
    @ResponseBody
    public String createNewModeler() throws UnsupportedEncodingException {

        //新建模型
        Model model = repositoryService.newModel();
        model.setName("new design model");
        model.setCategory("namespace");
        model.setKey("form design key");
        model.setVersion(1);

        ObjectNode metaNode = objectMapper.createObjectNode();
        metaNode.put(ModelDataJsonConstants.MODEL_NAME, "new modeler");
        metaNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
        metaNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, "no formal data");
        model.setMetaInfo(metaNode.toString());

        //保存模型
        repositoryService.saveModel(model);
        //为模型生成一个空的wf模型
        ObjectNode editorNode = new ObjectMapper().createObjectNode();
        //id和resource可以没有
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode stencilSetNode = objectMapper.createObjectNode();
        //namespace的值和stencilset.json中namespace的值相同,
        stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.put("stencilset", stencilSetNode);

        //只添加bpmn的json数据即可
        repositoryService.addModelEditorSource(model.getId(),
            editorNode.toString().getBytes("utf-8"));

        return model.getId();
    }

}

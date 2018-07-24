package com.test.demo.controller;

import com.test.demo.common.msg.ResponseModel;
import com.test.demo.common.vo.ComBoxData;
import com.test.demo.service.ICommonBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 处理所有下拉框的数据结构
 *
 * @author Ben
 * @create 2018-07-24 15:26
 **/
@RestController
@RequestMapping("/comBox")
public class CommonBoxController {

    @Autowired
    private ICommonBoxService commonBoxService;

    @RequestMapping(value = "/getDistrictByArea", method = RequestMethod.POST)
    public List<ComBoxData> getDistrictByArea(String areaName) {
        return commonBoxService.getDistrictInfoByArea(areaName);
    }
}

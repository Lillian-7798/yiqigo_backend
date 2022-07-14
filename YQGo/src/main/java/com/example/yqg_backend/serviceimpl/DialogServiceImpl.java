package com.example.yqg_backend.serviceimpl;

import com.example.yqg_backend.dao.DialogDao;
import com.example.yqg_backend.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DialogServiceImpl implements DialogService {
    @Autowired
    private DialogDao dialogDao;

    @Override
    public List<Map<String, Object>> getDialogsByUser(Integer userID) {
        return dialogDao.getDialogsByUser(userID);
    }
}

package com.example.yqg_backend.service;

import java.util.List;
import java.util.Map;

public interface DialogService {
    List<Map<String, Object>> getDialogsByUser(Integer userID);
}

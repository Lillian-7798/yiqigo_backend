package com.example.yqg_backend.dao;

import java.util.List;
import java.util.Map;

public interface DialogDao {
    List<Map<String, Object>> getDialogsByUser(Integer userID);
}

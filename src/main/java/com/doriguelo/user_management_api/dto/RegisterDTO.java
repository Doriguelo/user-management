package com.doriguelo.user_management_api.dto;

import com.doriguelo.user_management_api.entity.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {}

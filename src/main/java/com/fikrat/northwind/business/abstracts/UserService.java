package com.fikrat.northwind.business.abstracts;

import com.fikrat.northwind.core.entities.User;
import com.fikrat.northwind.core.utilities.results.DataResult;
import com.fikrat.northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> getByEmail(String email);
}

package com.ushmodin.patterns.dao;

import com.ushmodin.vehicle.Transport;

public interface DAO {
    void save(Transport transport);
    Transport load();
}

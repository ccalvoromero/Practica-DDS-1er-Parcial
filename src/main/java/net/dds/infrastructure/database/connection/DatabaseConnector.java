package net.dds.infrastructure.database.connection;

import java.sql.Connection;

public interface DatabaseConnector {
    Connection create();
}

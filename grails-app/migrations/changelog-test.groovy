databaseChangeLog = {

    changeSet(author: "FelixSchrader (generated)", id: "1765286333497-1") {
        createSequence(cacheSize: "1", cycle: "false", dataType: "bigint", incrementBy: "50", maxValue: "9223372036854775807", minValue: "1", sequenceName: "example_seq", startValue: "1")
    }

    changeSet(author: "FelixSchrader (generated)", id: "1765286333497-2") {
        createTable(tableName: "example") {
            column(name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "example_pkey")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "text", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }
}


package DTO;

public enum EmployeePermission {
    MANAGER("manager", "Quản lý", 0),
    STAFF("staff", "Nhân viên", 1),
    INACTIVE("inactive", "Nghỉ việc", 2);
    private String id, name;
    private int priority;

    EmployeePermission(String id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public static EmployeePermission getMANAGER() {
        return MANAGER;
    }

    public static EmployeePermission getSTAFF() {
        return STAFF;
    }

    public static EmployeePermission getINACTIVE() {
        return INACTIVE;
    }

    public int getPriority() {
        return priority;
    }
    
    public static EmployeePermission getById(String id) {
        for (EmployeePermission e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return STAFF;
    }

    public static EmployeePermission getByName(String name) {
        for (EmployeePermission e : values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return STAFF;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int compare(EmployeePermission other) {
        return priority - other.priority;
    }

}


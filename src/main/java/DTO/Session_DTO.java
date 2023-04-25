
package DTO;

import java.sql.Timestamp;


public class Session_DTO {
    private int id;
    private int idEmployee;
    private String nameEmployee;
    private Timestamp startTime;
    private Timestamp endTime;
    private String message;

    public Session_DTO(int id, int idEmployee, String nameEmployee, Timestamp startTime, Timestamp endTime, String message) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.startTime = startTime;
        this.endTime = endTime;
        this.message = message;
    }

    public Session_DTO() {
    }

    public int getId() {
        return id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Session_DTO{" + "id=" + id + ", idEmployee=" + idEmployee + ", nameEmployee=" + nameEmployee + ", startTime=" + startTime + ", endTime=" + endTime + ", message=" + message + '}';
    }
    
    
}

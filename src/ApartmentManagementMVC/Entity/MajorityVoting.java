package ApartmentManagementMVC.Entity;

import java.util.Date;

/**
 *
 * @author emreo
 */
public class MajorityVoting {
    private int id;
    private int apartmentId;
    private String topic;
    private String description;
    private boolean result;
    private Date date;
    private int requiredVotes;

    public MajorityVoting() {
    }

    public MajorityVoting(int apartmentId, String topic, String description, boolean Result, Date date, int requiredVotes) {
        this.apartmentId = apartmentId;
        this.topic = topic;
        this.description = description;
        this.result = result;
        this.date = date;
        this.requiredVotes = requiredVotes;
    }

    public MajorityVoting(int id, int apartmentId, String topic, String description, boolean Result, Date date, int requiredVotes) {
        this.id = id;
        this.apartmentId = apartmentId;
        this.topic = topic;
        this.description = description;
        this.result = result;
        this.date = date;
        this.requiredVotes = requiredVotes;
    }

    public int getId() {
        return id;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public boolean isResult() {
        return result;
    }

    public Date getDate() {
        return date;
    }

    public int getRequiredVotes() {
        return requiredVotes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResult(boolean Result) {
        this.result = result;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setRequiredVotes(int requiredVotes) {
        this.requiredVotes = requiredVotes;
    }

    public Object getByName(String field){
        switch(field)
        {
            case "Id": return id;
            case "ApartmentId":return apartmentId;
            case "Topic": return topic;
            case "Description": return description;
            case "Result": return result;
            case "Date": return date;
            case "RequiredVotes": return requiredVotes;
            default: return null;
        }
    }

    @Override
    public String toString(){
        return id +", " + apartmentId + ", " + topic + ", " + description+ ", "+ result + ", " + date + ", "  + requiredVotes;
    }
}

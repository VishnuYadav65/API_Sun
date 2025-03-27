public class AuthPojo {

    public  String clientName;
    public  String clientEmail;

    public AuthPojo(String clientName, String clientEmail)
    {
        this.clientName=clientName;
        this.clientEmail=clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return "AuthPojo{" +
                "clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}

package model;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private Integer user_id;
    private String user_uuid;
    private String user_name;
    private String user_email;
    private String user_password;
    private boolean is_deleted;
    private boolean is_verified;

    public User(String user_uuid, String user_name, String user_email, String user_password, boolean is_deleted, boolean is_verified) {
        this.user_uuid = user_uuid;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.is_deleted = is_deleted;
        this.is_verified = is_verified;
    }

}


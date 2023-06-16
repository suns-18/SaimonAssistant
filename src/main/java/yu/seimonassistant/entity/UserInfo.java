package yu.seimonassistant.entity;

import lombok.Data;

/**
 * Table: userinfo
 */
@Data
public class UserInfo {
    /**
     * Column: id
     * Type: VARCHAR(255)
     */
    private String id;

    /**
     * Column: username
     * Type: VARCHAR(255)
     */
    private String username;

    /**
     * Column: password
     * Type: VARCHAR(255)
     */
    private String password;
}
package com.somo.test.server;

/**
 * Created by Kimyebon on 16. 4. 2..
 */
public class RequirementRequest {
    String content;
    String room_number;

    public RequirementRequest(String content, String room_number) {
        this.content = content;
        this.room_number = room_number;
    }
}

package project.POJO.ResponseAPIEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import project.POJO.RequestEntity.RequestEntity;

@Data
@Setter
@AllArgsConstructor
public class ResponseAPIHolder {
    private ResponseHolder responseHolder;
    private RequestEntity requestEntity;
}

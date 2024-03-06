package org.nksofttech.userprofileservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nksofttech.userprofileservice.util.enums.ResMessage;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
  private int code;
  private ResMessage message;
  private Object data;
}

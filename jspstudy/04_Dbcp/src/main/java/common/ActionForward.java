package common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionForward {
	// 어떤 jsp로 리다이렉트 할것인지?
	private String view;
	private boolean isRedirect;
}
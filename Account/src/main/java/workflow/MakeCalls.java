package workflow;

import java.util.Arrays;
import java.util.List;

public class MakeCalls {
  /*
  *
  * You are given a Server interface, see Server.java.
  * This interface exposed 3 APIs, with some predefined exceptions/
  *
  * You will be given an order in which these APIs are to be called.
  * You are given order in which these APIs are to be called and retry count.
  * You will need to call these APIs, while handling all the errors you get.
  *
  * */
  private static final int RETRY_COUNT = 3;
  private static final List<String> order = Arrays.asList("api1", "api2", "api3");
  private final  Server server = new ServerImplementation();

}

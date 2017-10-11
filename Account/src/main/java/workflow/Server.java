package workflow;

import workflow.exceptions.InvalidCallException;
import workflow.exceptions.ServerAtCapacityException;
import workflow.exceptions.TimeoutException;

public interface Server {
  public void api1() throws ServerAtCapacityException, InvalidCallException, TimeoutException;
  public void api2() throws ServerAtCapacityException, InvalidCallException, TimeoutException;
  public void api3() throws ServerAtCapacityException, InvalidCallException, TimeoutException;
}

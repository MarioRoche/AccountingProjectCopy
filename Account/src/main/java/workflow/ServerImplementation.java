package workflow;

import java.util.Random;

import workflow.exceptions.InvalidCallException;
import workflow.exceptions.ServerAtCapacityException;
import workflow.exceptions.TimeoutException;

public class ServerImplementation implements Server {
  Random rn = new Random();

  public void api1() throws ServerAtCapacityException, InvalidCallException, TimeoutException {
    int next = rn.nextInt(10);
    if(next < 2) throw new TimeoutException();
    if(next < 4) throw new ServerAtCapacityException();
    if(next < 6) throw new InvalidCallException();
    System.out.println("api1 called");
    return;
  }

  public void api2() throws ServerAtCapacityException, InvalidCallException, TimeoutException {
    int next = rn.nextInt(10);
    if(next < 2) throw new TimeoutException();
    if(next < 4) throw new ServerAtCapacityException();
    if(next < 6) throw new InvalidCallException();
    System.out.println("api2 called");
    return;
  }

  public void api3() throws ServerAtCapacityException, InvalidCallException, TimeoutException {
    int next = rn.nextInt(10);
    if(next < 2) throw new TimeoutException();
    if(next < 4) throw new ServerAtCapacityException();
    if(next < 6) throw new InvalidCallException();
    System.out.println("api3 called");
    return;
  }
}

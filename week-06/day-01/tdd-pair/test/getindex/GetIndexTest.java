package getindex;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GetIndexTest {

  private GetIndex getIndex;
  private List<Integer> list;

  @Before
  public void setup() {
    getIndex = new GetIndex();
    list = new ArrayList<>(Arrays.asList(2, 5, 3, 7, 1));
  }

  @Test
  public void getIndexShouldReturnOne() {
    assertEquals(1, getIndex.get(list, 5));
  }

  @Test
  public void getIndexShouldReturnMinusOne() {
    assertEquals(-1, getIndex.get(list, 6));
  }

}
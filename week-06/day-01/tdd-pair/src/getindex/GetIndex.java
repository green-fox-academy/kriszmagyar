package getindex;

import java.util.List;

class GetIndex {

  int get(List<Integer> list, int inputValue) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == inputValue) {
        return i;
      }
    }
    return -1;
  }
}

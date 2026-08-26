class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {

        ArrayList<Pair> li = map.get(key);

        if(li == null) {
            return "";
        }

        int l = 0;
        int r = li.size() - 1;

        String ans = "";

        while(l <= r) {

            int mid = (l + r) / 2;

            if(li.get(mid).timestamp <= timestamp) {

                ans = li.get(mid).value;

                l = mid + 1;

            } else {

                r = mid - 1;
            }
        }

        return ans;
    }
}
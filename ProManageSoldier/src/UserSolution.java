import java.util.HashMap;
import java.util.Map;

class Member {
    int team;
    int score;

    public Member(int team, int score) {
        this.team = team;
        this.score = score;
    }
}

public class UserSolution {
    HashMap<Integer, Member> allMembers;
    HashMap<Integer, Member>[] teamMaps;

    public void init() {
        allMembers = new HashMap<>();
        teamMaps = new HashMap[6];
        for (int i = 1; i <= 5; i++) {
            teamMaps[i] = new HashMap<>();
        }
    }

    public void hire(int mID, int mTeam, int mScore) {
        Member m = new Member(mTeam, mScore);
        allMembers.put(mID, m);
        teamMaps[mTeam].put(mID, m);
    }

    public void fire(int mId) {
        Member m = allMembers.get(mId);
        if (m != null) {
            teamMaps[m.team].remove(mId);
            allMembers.remove(mId);
        }
    }

    public void updateSoldier(int mID, int mScore) {
        Member m = allMembers.get(mID);
        if (m != null) {
            m.score = mScore;
        }
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        for (Member m : teamMaps[mTeam].values()) {
            int temp = m.score + mChangeScore;
            if (temp > 5) temp = 5;
            else if (temp < 1) temp = 1;
            m.score = temp;
        }
    }

    public int bestSoldier(int mTeam) {
        int rst = -1;
        int max = -1;
        for (Map.Entry<Integer, Member> entry : teamMaps[mTeam].entrySet()) {
            int id = entry.getKey();
            int score = entry.getValue().score;

            if (score > max) {
                max = score;
                rst = id;
            } else if (score == max) {
                if (id > rst) {
                    rst = id;
                }
            }
        }
        return rst;
    }
}
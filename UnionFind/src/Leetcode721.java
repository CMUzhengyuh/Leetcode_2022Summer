import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
/**
 * 07/22/2022
 */
public class Leetcode721 {

    /**
     * Leetcode 721 - Accounts Merge (Medium)
     * This problem can be solved as a union find problem in this way:
     * HashMap owners stores the mapping of email -> name.
     * HashMap parent stores the mapping of email -> parent node.
     * HashMap unions stores the mapping of name -> all e-mails.
     * (1) Initialize the owner and parent information for input array.
     * (2) Union possible account if needed.
     * (3) Utilize TreeSet output to form the result/
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owners = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();

        for (List<String> account: accounts) {
            for (int i = 1; i < account.size(); i++) {
                String owner = account.get(0);
                String email = account.get(i);
                parent.put(email, email);
                owners.put(email, owner);
            }
        }

        for (List<String> account: accounts) {
            String p1 = find(parent, account.get(1));
            for (int i = 2; i < account.size(); i++) {
                String p2 = find(parent, account.get(i));
                parent.put(p2, p1);
            }
        }

        for (List<String> account: accounts) {
            String p1 = find(parent, account.get(1));
            if (!unions.containsKey(p1)) {
                unions.put(p1, new TreeSet<>());
            }
            Set<String> emailSets = unions.get(p1);
            for (int i = 1; i < account.size(); i++) {
                emailSets.add(account.get(i));
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owners.get(p));
            res.add(emails);
        }
        return res;
    }

    public String find(Map<String, String> parents, String node) {
        while (!parents.get(node).equals(node)) {
            parents.put(node, parents.get(parents.get(node)));
            node = parents.get(node);
        }
        return node;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        Queue<NodeWrapper> lotq = new ArrayDeque<>();
        Map<Integer, List<NodeWrapper>> hdMap = new TreeMap<>();
        lotq.add(new NodeWrapper(root, 0, 0));

        while (!lotq.isEmpty()) {
            NodeWrapper curr = lotq.poll();

            if (hdMap.containsKey(curr.hd)) {
                List<NodeWrapper> currHdNws = hdMap.get(curr.hd);
                NodeWrapper currHdLastNw = currHdNws.get(currHdNws.size() - 1);

                /* find correct index where curr should be placed
                   because question mentions that smaller elements
                   should come before bigger elements when we are
                   considering same level and same hd.
                */
                int indToInsert = currHdNws.size(); //default value
                for (; indToInsert > 0 && currHdNws.get(indToInsert - 1).level == curr.level && curr.node.val < currHdNws.get(indToInsert - 1).node.val; indToInsert--);
                
                if (indToInsert == currHdNws.size()) {
                    currHdNws.add(curr);
                }
                else {
                    // move bigger elements (at same hd and level) forward
                    for (int i = currHdNws.size(); i > indToInsert && i > 0; i--) {
                        if (i == currHdNws.size()) {
                            currHdNws.add(currHdNws.get(i - 1));
                        }
                        else {
                            currHdNws.set(i, currHdNws.get(i - 1));
                        }
                    }

                    //add curr at the required index now
                    currHdNws.set(indToInsert, curr);
                }
            } else {
                List<NodeWrapper> vals = new ArrayList<>();
                vals.add(curr);
                hdMap.put(curr.hd, vals);
            }

            if (curr.node.left != null) {
                lotq.add(new NodeWrapper(curr.node.left, curr.hd - 1, curr.level + 1));
            }

            if (curr.node.right != null) {
                lotq.add(new NodeWrapper(curr.node.right, curr.hd + 1, curr.level + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int hd : hdMap.keySet()) {
            ans.add(hdMap.get(hd).stream().map(a -> a.node.val).collect(java.util.stream.Collectors.toList()));
        }

        return ans;
    }
}

class NodeWrapper {
    TreeNode node;
    int hd;
    int level;

    NodeWrapper(TreeNode node, int hd, int level) {
        this.node = node;
        this.hd = hd;
        this.level = level;
    }
}
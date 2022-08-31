import java.util.ArrayList;
import java.util.List;

public class _NewString_ {
    /**
     * Block of character to store the string.
     */
    private class Block {
        List<Character> data;
        public Block() {
            this.data = new ArrayList<>();
        }
    }

    /**
     * List of Block.
     */
    private List<Block> blockList;

    /**
     * Total number of newString.
     */
    private int totalSize;

    /**
     * Size of a single Block.
     */
    private int blockSize;

    public _NewString_() {
        this.blockList = new ArrayList<>();
        this.totalSize = 0;
        this.blockSize = 0;
    }

    /**
     * Get API to fetch the character in the given position.
     */
    public Character get(int pos) {
        int[] array = find(pos);
        int index = array[0];
        pos = array[1];
        if (pos == -1) {
            return null;
        }
        Block block = blockList.get(index);
        return block.data.get(pos);
    }

    /**
     * Insert API to add a character to the given position.
     */
    public void insert(char c, int pos) {
        totalSize++;
        blockSize = (int) Math.sqrt(totalSize);
        if (blockList.size() == 0) {
            Block block = new Block();
            block.data.add(c);
            blockList.add(block);
        } else {
            int[] val = find(pos);
            int blockNumber = val[0];
            int index = val[1];
            Block block = blockList.get(blockNumber);
            if (index == -1) {
                block.data.add(c);
            } else {
                block.data.add(index, c);
            }
        }
        maintain();
    }

    /**
     * Remove API to remove a character in the given position.
     */
    public void remove(int pos) {
        int[] val = find(pos);
        int blockNumber = val[0];
        int index = val[1];
        if (index == -1) {
            return;
        }
        Block block = blockList.get(blockNumber);
        totalSize--;
        blockSize = (int) Math.sqrt(totalSize);
        block.data.remove(index);
        maintain();
    }

    /**
     * Helper function to find the block number and index within the block.
     * Return: [blockNumber, indexInBlock]
     */
    private int[] find(int pos) {
        for (int i = 0; i < blockList.size(); i++) {
            int curSize = blockList.get(i).data.size();
            if (curSize > pos) {
                return new int[]{i, pos};
            } else {
                pos -= curSize;
            }
        }
        return new int[]{blockList.size() - 1, -1};
    }

    /**
     * Helper function to check if blockList need to resize.
     * (1) Split if size > 2 * blockSize.
     * (2) Merge if size < blockSize.
     */
    private void maintain() {
        for (int i = 0; i < blockList.size(); i++) {
            Block curBlock = blockList.get(i);
            if (curBlock.data.size() > 2 * blockSize) {
                Block newBlock = new Block();
                List<Character> list = curBlock.data;
                newBlock.data = new ArrayList<>(list.subList(0, blockSize));
                curBlock.data = new ArrayList<>(list.subList(blockSize, list.size()));
                blockList.add(i, newBlock);
            }
        }

        for (int i = 0; i < blockList.size() - 1; i++) {
            Block curBlock = blockList.get(i);
            Block nextBlock = blockList.get(i + 1);
            if (curBlock.data.size() + nextBlock.data.size() < blockSize) {
                curBlock.data.addAll(nextBlock.data);
                blockList.remove(i + 1);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Block block : blockList) {
            for (char c : block.data) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _NewString_ bl = new _NewString_();
        bl.insert('a', 10);
        bl.insert('b', 10);
        bl.insert('c', 10);
        bl.insert('d', 10);
        bl.insert('e', 1);
        bl.insert('k', 1);
        bl.insert('t', 1);
        bl.insert('m', 1);
        bl.insert('n', 1);
        System.out.println(bl.toString());
        System.out.println(bl.get(7));
        bl.remove(7);
        System.out.println(bl.toString());       // anmtkebd
        bl.remove(7);                       // anmtkeb
        bl.remove(4);                       // anmteb
        bl.remove(4);                       // anmtb
        System.out.println(bl.toString());       // anmtb
        bl.remove(3);                       // anmb
        System.out.println(bl.toString());
    }
}

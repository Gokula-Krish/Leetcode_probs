/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Iterator<Integer> it;
    List<Integer> ls=new ArrayList();
    public void getLists(NestedInteger nInt){
        if(nInt.isInteger()){
            ls.add(nInt.getInteger());
            return;
        }
        else{
            for(NestedInteger n:nInt.getList()){
                getLists(n);
            }
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger l:nestedList){
            if(l.isInteger()){
                ls.add(l.getInteger());
            }
            else{
                getLists(l);
            }
        }
        it=ls.iterator();
    }

    @Override
    public Integer next() {
        return hasNext()?it.next():null;
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
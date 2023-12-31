package globaloutbreak.model.pair;
/**
 * Implement. of PairInt.
 * @param <X> 
 *              generic X
 * @param <Y> 
 *              generic Y
 */
public final class Pair<X, Y> implements PairInt<X, Y> {

    private final X x;
    private final Y y;
    /**
    * Constructor.
    * @param x
    *           generic X
    * @param y
    *           generic Y
    */
    public Pair(final X x, final Y y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public X getX() {
        return x;
    }

    @Override
    public Y getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (x == null) {
            if (other.x != null) {
                return false;
            }
        } else if (!x.equals(other.x)) {
            return false;
        }
        if (y == null) {
            if (other.y != null) {
                return false;
            }
        } else if (!y.equals(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pair [x=" + x + ", y=" + y + "]";
    }

}


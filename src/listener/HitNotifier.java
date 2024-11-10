//207829763 Matan Jack
package listener;

/**
 * The HitNotifier interface should be implemented by any class that can notify listeners of hit events.
 * Implementing classes should manage the addition and removal of HitListener objects.
 *
 * @author Matan Jack
 * @version 1
 * @since 2024-07-04
 */
public interface HitNotifier {
    /**
     * Adds hl as a listener to hit events.
     *
     * @param hl the HitListener to be added
     */
    void addHitListener(HitListener hl);

    /**
     * Removes hl from the list of listeners to hit events.
     *
     * @param hl the HitListener to be removed
     */
    void removeHitListener(HitListener hl);
}
package by.epam.evm.pyramid.observer;

import by.epam.evm.pyramid.model.Point;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class PyramidObservableTest {

    @Test
    public void testSetApexShouldCallObserverNotifyMethodWhenCallNotifyObservers() {
        //given
        PyramidObservable observable = new PyramidObservable();
        PyramidObserver observer = Mockito.mock(PyramidObserver.class);
        observable.addObserver(observer);
        Point point = new Point(1, 1, 1);
        //when
        observable.setApexPoint(point);
        //then
        verify(observer).notify(any());
    }
}

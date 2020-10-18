package by.epam.evm.pyramid.observer;

import by.epam.evm.pyramid.logic.PyramidCalculator;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PyramidObserverTest {

    @Test
    public void testNotifyShouldCallCalculateAreaWhenDataCalculate() {
        //given
        PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);
        PyramidObservable pyramid = Mockito.mock(PyramidObservable.class);
        when(pyramid.getId()).thenReturn(1);
        Observer observer = new PyramidObserver(calculator);
        //when
        observer.notify(pyramid);
        //then
        verify(calculator).calculateArea(any());
    }

    @Test
    public void testNotifyShouldCallCalculateVolumeWhenDataCalculate() {
        //given
        PyramidCalculator calculator = Mockito.mock(PyramidCalculator.class);
        PyramidObservable pyramid = Mockito.mock(PyramidObservable.class);
        when(pyramid.getId()).thenReturn(1);
        Observer observer = new PyramidObserver(calculator);
        //when
        observer.notify(pyramid);
        //then
        verify(calculator).calculateVolume(any());
    }
}

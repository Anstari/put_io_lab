package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpensesTest() {
        IFancyDatabase obiekt = mock(IFancyDatabase.class);
        assert obiekt.queryAll().isEmpty();
        ExpenseRepository repository = new ExpenseRepository(obiekt);
        repository.loadExpenses();

        InOrder inOrder = inOrder(obiekt, obiekt);

        inOrder.verify(obiekt).connect();
        inOrder.verify(obiekt).close();
        verify(obiekt, times(2)).queryAll();
    }

    @Test
    void saveExpensesTest(){
        IFancyDatabase obiekt = mock(IFancyDatabase.class);
        assert obiekt.queryAll().isEmpty();
        ExpenseRepository repository = new ExpenseRepository(obiekt);
        repository.saveExpenses();

        verify(obiekt).persist(any());
    }


}

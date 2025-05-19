
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.controller.OperationFailedException;

import static org.junit.jupiter.api.Assertions.*;

class OperationFailedExceptionTest {

    @Test
    void testExceptionMessageAndCause() {
        String message = "Could not retrieve item";
        Exception cause = new Exception("Database failure");
        OperationFailedException exception = new OperationFailedException(message, cause);


        assertEquals(msg, exception.getMessage(), "The message should be correctly stored");
        assertSame(cause, exception.getCause(), "The cause should be correctly stored and retrievable.");
    }



}

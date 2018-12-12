package com.github.f4b6a3.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.github.f4b6a3.uuid.UuidCreatorTest;
import com.github.f4b6a3.uuid.clockseq.DefaultClockSequenceStrategyTest;
import com.github.f4b6a3.uuid.factory.abst.AbstractUuidCreatorTest;
import com.github.f4b6a3.uuid.sequence.AbstractSequenceTest;
import com.github.f4b6a3.uuid.timestamp.DefaultTimestampStrategyTest;
import com.github.f4b6a3.uuid.util.ByteUtilTest;
import com.github.f4b6a3.uuid.util.TimestampUtilTest;
import com.github.f4b6a3.uuid.util.UuidUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   UuidCreatorTest.class,
   AbstractUuidCreatorTest.class,
   AbstractSequenceTest.class,
   DefaultClockSequenceStrategyTest.class,
   DefaultTimestampStrategyTest.class,
   ByteUtilTest.class,
   TimestampUtilTest.class,
   UuidUtilTest.class
})

public class TestSuite {   
}  	
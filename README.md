# crossengage

The implementation separates each role of processing into a separate class which implements a specific interface to make DI enabled

I used a BlockingQueue implementation to collect items then check when to flush the processing
which means the the chunk of data are ready to be processed

configuration are loaded from external file in resources folder.
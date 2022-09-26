package com.example.androidpracticaltest.utils


import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*

 fun <ResultType, RequestType>networkBoundResource(
     query: () -> Flow<ResultType>,
     fetch: suspend () -> RequestType,
     saveFetchResult: suspend (RequestType) -> Unit,
     shouldFetch:(ResultType) -> Boolean = { true }
)= flow {
    val data = query().first()

    val flow = if (shouldFetch(data)){

        //This where the issue is; saying that can't invoke suspend function
        emit(Resource.Loading(data))

        //I have added the try-catch here
        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        }catch (throwable: Throwable) {
            query().map { Resource.Error(throwable, it) }
        }
    }else{
        query().map { Resource.Success(it) }
    }

    emitAll(flow)

}
package com.ronit.ribbble.presentation.base_mvp.api

import android.support.annotation.CallSuper
import com.ronit.ribbble.domain.fetcher.Fetcher
import com.ronit.ribbble.domain.fetcher.Status
import com.ronit.ribbble.domain.fetcher.result_listener.RequestType
import com.ronit.ribbble.domain.fetcher.result_listener.ResultListener
import com.ronit.ribbble.presentation.base_mvp.base.BaseContract
import com.ronit.ribbble.presentation.base_mvp.base.BasePresenter
import io.reactivex.Flowable
import javax.inject.Inject

abstract class ApiPresenter<VIEW: BaseContract.View> : BasePresenter<VIEW>(), ResultListener {

    @Inject
    protected lateinit var fetcher: Fetcher

    private val TYPE_NONE = RequestType.TYPE_NONE
    protected val AUTH: RequestType = RequestType.AUTH
    protected val POPULAR_SHOTS = RequestType.POPULAR_SHOT
    protected val RECENT_SHOTS = RequestType.RECENT_SHOTS
    protected val FOLLOWING_SHOTS = RequestType.FOLLOWINGS_SHOTS
    protected val LIKED_SHOTS = RequestType.LIKED_SHOTS
    protected val COMMENTS = RequestType.COMMENTS
    protected val LIKE = RequestType.LIKE
    protected val SUCCESS = Status.SUCCESS
    protected val LOADING = Status.LOADING
    protected val ERROR = Status.ERROR
    protected val EMPTY_SUCCESS = Status.EMPTY_SUCCESS

    protected infix fun RequestType.statusIs(status: Status) = fetcher.getRequestStatus(this) == status

    protected val RequestType.status
        get() = fetcher.getRequestStatus(this)


    fun <TYPE>fetch(flowable: Flowable<TYPE>,
                    requestType: RequestType = TYPE_NONE, success: (TYPE) -> Unit) {
        fetcher.fetch(flowable, requestType, this, success)
    }

    @CallSuper
    override fun onPresenterDestroy() {
        super.onPresenterDestroy()
        fetcher.clear()
    }

    @CallSuper
    override fun onRequestStart(requestType: RequestType) {
        onRequestStart()
    }

    @CallSuper
    override fun onRequestError(requestType: RequestType, errorMessage: String?) {
        onRequestError(errorMessage)
    }




}
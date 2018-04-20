package com.ronit.ribbble.presentation.base_mvp.base

import io.armcha.arch.BaseMVPPresenter

abstract class BasePresenter<V : BaseContract.View> : BaseMVPPresenter<V>(), BaseContract.Presenter<V>
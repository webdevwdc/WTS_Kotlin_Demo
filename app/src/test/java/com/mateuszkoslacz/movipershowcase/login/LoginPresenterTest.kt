package joz.spekdemo.login


import com.gox.RxSchedulersOverrideSpek
import com.mateuszkoslacz.movipershowcase.data.LoginBundle
import com.mateuszkoslacz.movipershowcase.model.LoginResponse
import com.mateuszkoslacz.movipershowcase.viper.login.LoginContract
import com.mateuszkoslacz.movipershowcase.viper.login.LoginPresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.whenever
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.api.include
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.mockito.Mockito.inOrder
import org.mockito.stubbing.OngoingStubbing
import rx.schedulers.Schedulers
import rx.subjects.PublishSubject

//@RunWith(JUnitPlatform::class)
class LoginPresenterTest : Spek({

    include(RxSchedulersOverrideSpek)

    given("Login Request") {

        var view: LoginContract.View = mock()
        var interactor: LoginContract.Interactor = mock()
        var inOrder = inOrder(view, interactor)

        val subjectLoginResponse = PublishSubject.create<LoginResponse>()
        val subjectIsUserLoggedIn = PublishSubject.create<Boolean>()

        var presenter: LoginPresenter

        beforeEachTest {

            view = mock()
            interactor = mock()
            inOrder = inOrder(view, interactor)

            whenever(interactor.performLogin(loginBundle = LoginBundle("partha", "123456"))).thenReturn(subjectLoginResponse)
            //whenever(interactor.isUserLoggedIn()).thenReturn(subjectIsUserLoggedIn)
            presenter= LoginPresenter();
            //presenter = LoginPresenter(view, interactor, view.showLoading(), view)
            presenter.routing
        }

        on("user is already LOGGED IN") {

            subjectIsUserLoggedIn.onNext(true)

            it("shows progress") {
                inOrder.verify(view).showLoading()
            }

            /*it("checks is user already logged in") {
                inOrder.verify(interactor).isUserLoggedIn()
            }

            it("doesn't send a login request") {
                inOrder.verify(interactor, never()).sendLoginRequest()
            }*/

            /*it("hides the progress") {
                inOrder.verify(view).hideProgress()
            }*/

            it("shows logged in screen") {
                inOrder.verify(view).loginClicks
            }

            it("doesn't have extra interactions") {
                inOrder.verifyNoMoreInteractions()
            }
        }

        on("login response is OK") {

            subjectIsUserLoggedIn.onNext(false)
            subjectLoginResponse.onNext(LoginResponse())

            it("shows progress") {
                inOrder.verify(view).showLoading()
            }

           /* it("checks is user already logged in") {
                inOrder.verify(interactor).isUserLoggedIn()
            }

            it("sends login request") {
                inOrder.verify(interactor).sendLoginRequest()
            }*/

           /* it("hides the progress") {
                inOrder.verify(view).hideProgress()
            }*/

            it("shows logged in view") {
                inOrder.verify(view).loginClicks
            }

            it("doesn't have extra interactions") {
                inOrder.verifyNoMoreInteractions()
            }

        }

        on("login response is NOT OK") {

            subjectIsUserLoggedIn.onNext(false)
            subjectLoginResponse.onError(Throwable("Some Error"))

            it("shows progress") {
                inOrder.verify(view).showLoading()
            }

            /*it("checks is user already logged in") {
                inOrder.verify(interactor).isUserLoggedIn()
            }

            it("sends login request") {
                inOrder.verify(interactor).sendLoginRequest()
            }

            it("hides the progress") {
                inOrder.verify(view).hideProgress()
            }*/

            it("shows error view") {
                inOrder.verify(view).showError(Throwable("Some Error"))
            }

            it("doesn't have extra interactions") {
                inOrder.verifyNoMoreInteractions()
            }
        }

    }

})

private fun <T> OngoingStubbing<T>.thenReturn(subjectLoginResponse: PublishSubject<LoginResponse>?) {

}

package id.petersam.resik.external.base

abstract class BaseUseCase<Params, out T> {
    abstract suspend operator fun invoke(params: Params): T

    class None
}

package io.vaan.asare.backend.programs

import io.vaan.asare.backend.algrebras.rebalancer.RebalancerA
import io.vaan.asare.backend.domain.rebalance._
import cats.effect._
import cats.syntax.all._

final class RebalancerP[F[_]: Sync](
    rebalancerA: RebalancerA[F]
) {
  def rebalance(input: RebalanceInput): F[RebalanceOutput] =
    for {
      allocation <- rebalancerA.calcCurrentAllocation(input.currentPortfolio)
      operations <- rebalancerA.calcPurchase(input)
    } yield RebalanceOutput(
      currentAllocation = allocation,
      requiredOperations = operations
    )
}

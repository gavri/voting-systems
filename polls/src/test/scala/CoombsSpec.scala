package com.example.gavri.polls

import org.scalatest._

class CoombsSpec extends FunSpec with Matchers with Factory {
  describe("Coombs") {
    it("should degenerate to plurality") {
      val firstCandidate = Candidate("first candidate")
      val firstBallotSheet = BallotSheet(List(firstCandidate))
      val secondBallotSheet = BallotSheet(List(Candidate("second candidate")))
      val thirdBallotSheet = BallotSheet(List(firstCandidate))
      val coombs = Coombs(List(firstBallotSheet, secondBallotSheet , thirdBallotSheet))
      coombs.winners should equal (Set(firstCandidate))
    }

    it("should promote the lower preferences of those who voted for the candidate with the most bottom votes") {
      val coombs = Coombs(ballots)
      coombs.winners should equal (Set(Candidate("coombs winner")))
    }

    it("should return an empty set if nobody voted") {
      val coombs = Coombs(List())
      coombs.winners should equal (Set())
    }
  }
}

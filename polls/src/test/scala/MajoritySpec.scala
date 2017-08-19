package com.example.gavri.polls

import org.scalatest._

class MajoritySpec extends FunSpec with Matchers {
  describe("Majority") {
    it("should return the candidate that has more than 50% of the votes"){
      val firstCandidate = Candidate("first candidate")
      val secondCandidate = Candidate("second candidate")
      val majority = new Majority(List(firstCandidate, secondCandidate, firstCandidate))
      majority.winner.get should equal (firstCandidate)
    }

    it("should not return any candidate if none of them have more than 50% of the votes") {
      val firstCandidate = Candidate("first candidate")
      val secondCandidate = Candidate("second candidate")
      val thirdCandidate = Candidate("third candidate")
      val majority = new Majority(List(firstCandidate, secondCandidate, firstCandidate, thirdCandidate, thirdCandidate))
      majority.winner should be (None)
    }
  }
}

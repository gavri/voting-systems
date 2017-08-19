package com.example.gavri.polls

class Candidate(name: String)
object Candidate {
  def apply(name: String) = new Candidate(name)
}

trait Election {
  def winners: Set[Candidate]
}

; Funções criadas para os gifs da minha palestra "Programação Funcional com Clojure"

(defn funcao-de-teste
    [nome idade]
    (str "Ola, " nome "!"))

(defn funcao-de-teste-2
    [nome idade]
    (let [saudacao (str "Ola, " nome "!")
          idade-menos-1 (- idade 1)]
    (str saudacao "sua idade menos um é: " idade-menos-1)))

(defn funcao-de-teste-2
    [nome idade]
    (let [saudacao (str "Ola, " nome "!")
          idade-menos-1 (- idade 1)]
    (str saudacao " Sua idade menos um é: " idade-menos-1)))

;=> (def usuario {:nome "Joao" :idade 20 :sexo "M"})
;=> (funcao-de-teste-3 usuario)
(defn funcao-de-teste-3
    [usuario]
    (let [nome (:nome usuario)
          idade (:idade usuario)
          sexo (:sexo usuario)
          saudacao (str "Ola, " nome "!")
          idade-menos-1 (- idade 1)]
      (str saudacao " Sua idade menos um é: " idade-menos-1)))

(defn funcao-de-teste-3
  [{:keys [nome idade]}]
  (let [saudacao (str "Ola, " nome "!")
        idade-menos-1 (- idade 1)]
      (str saudacao " Sua idade menos um é: " idade-menos-1)))

(defn funcao-de-teste-4
    ([nome idade]
      (funcao-de-teste-4 nome idade "Indefinido"))
    ([nome idade sexo]
        (let [saudacao (str "Ola, " nome "!")
              idade-menos-1 (- idade 1)]
          (str saudacao " Sua idade menos um é: " idade-menos-1 " e seu sexo é: " sexo))))

(defn get-user-name
  ([] (get-user-name {:try-again? false}))
  ([{:keys [try-again?]}]
    (loop [name-typed (do (print (translate-name-try-again try-again?)) (flush) (read-line))]
      (if (interface/validate-user-info {:type :name :name-typed name-typed})
        name-typed
        (recur (get-user-name {:try-again? true}))))))

(defn usuario-existe
  [nome]
  (prn "Usuário existe!")
  (prn "Meu usuário é o: " nome))

(defn teste-mumu
  [user-map]
  (if-let [nome (:nome user-map)]
    (usuario-existe nome) ;; true
    (prn "Usuario nao encontrado") ;; else
    ))


(defn user-has-permission
  [user-age]
  (if (>= user-age 18)
    (do
      "maior de idade")
    "menor de idade"))
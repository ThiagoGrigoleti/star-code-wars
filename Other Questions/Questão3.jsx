import React, { useState } from 'react';

function Contador() {
  const [contador, setContador] = useState(0);

  const incrementar = () => {
    setContador(contador + 1);
  };

  const zerar = () => {
    setContador(0);
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h1>Contador: {contador}</h1>
      <button onClick={incrementar} style={{ margin: '10px', padding: '10px 20px', fontSize: '16px' }}>
        Incrementar
      </button>
      <button onClick={zerar} style={{ margin: '10px', padding: '10px 20px', fontSize: '16px' }}>
        Zerar
      </button>
    </div>
  );
}

export default Contador;
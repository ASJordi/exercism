import { hello } from '../src/ex-001.js'

test('hello', () => {
  expect(hello()).toEqual('Hello, World!')
})
